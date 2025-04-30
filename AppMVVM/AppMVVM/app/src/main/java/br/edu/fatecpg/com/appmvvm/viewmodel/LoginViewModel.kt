package br.edu.fatecpg.com.appmvvm.viewmodel

import androidx.lifecycle.ViewModel
import br.edu.fatecpg.com.appmvvm.model.User

class LoginViewModel: ViewModel() {
    private val users = mutableListOf<User>()

    fun register(login:String, pass:String):Boolean {
        if(login.isNotBlank() && pass.isNotBlank()){
            val user = User(login, pass)
            users.add(user)
            return true
        }
        return false
    }
    fun login(login: String, pass: String):Boolean{
        var result = false
        if(login.isNotBlank() && pass.isNotBlank()){
            result = users.any {
                it.login == login && it.password == pass
            }
        }
        return result
    }
}