package ir.fbscodes.kotlintest

import androidx.lifecycle.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.*

class MainViewModel : ViewModel() {
    private val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable -> errorLiveData.value = throwable.message }
    private val apiServices = ApiServicesDB().getApiServices()
    private val studentsLiveData : LiveData<List<Student>> = liveData(coroutineExceptionHandler) {
        val obj = apiServices.getStudents(1)
        if (obj.has("total") && obj.has("data")) {
            yield()
            val studentData = obj.getAsJsonArray("data")
            if (studentData.size() > 0) {
                val students = Gson().fromJson<List<Student>>(studentData.toString(), object : TypeToken<List<Student>>() {}.type)
                emit(students)
            }
        }
    }
    private val errorLiveData = MutableLiveData<String>()

    fun getStudentsLiveData(): LiveData<List<Student>> {
        return studentsLiveData
    }

    fun getErrorLiveData(): LiveData<String> {
        return errorLiveData
    }
}