package com.example.netlib.data.result

import android.util.Log
import com.example.netlib.data.dto.ApiError
import com.google.gson.Gson
import retrofit2.HttpException
import java.io.IOException

// Назначение: Адаптер для обработки ответа с сервера
// Автор: Дерябина В.Н.
// Дата создания: 25-05-2026
object ApiCallAdapter {
    suspend fun <T>safeApiCall(call: suspend ()-> T): NetworkResult<T>{
        return try {
            Log.d("[ApiCallAdapter]","Запрос - Success")
            NetworkResult.Success(call())
        }catch (e: HttpException){
            val errorBody = e.response()?.errorBody()?.toString()
            val errorMessage=try {
                val error = Gson().fromJson(errorBody, ApiError::class.java)
                error.message
            }catch (_: Exception){
                e.message
            }
            Log.d("[ApiCallAdapter]","Ошибка - ${e.code()}, $errorMessage")
            NetworkResult.Error(e.code(), errorMessage)
        }catch (e: IOException){
            Log.d("[ApiCallAdapter]","Ошибка - ${e.message}")
            NetworkResult.Exception( e.message)
        }
        catch (e: Throwable){
            Log.d("[ApiCallAdapter]","Ошибка - ${e.message}")
            NetworkResult.Exception( e.message)
        }
    }
}