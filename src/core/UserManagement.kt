package core

class UserManagement(private val userMaster: UserMaster) {

    private var _loggedInUser: User? = null

    var loggedInUser: User? = _loggedInUser
        get() = _loggedInUser
        private set

    fun registerNewUser(user: User) {
        userMaster.addUser(user)
    }

    fun deleteUser(userId: Int) {
        userMaster.removeUser(userId)
    }

    fun loginUser(mobileNumber: String, password: String): Boolean {
        this._loggedInUser = userMaster.getUser(mobileNumber,password)
        return this._loggedInUser != null
    }

    fun changePassword(mobileNumber: String, password: String, newPassword: String): Boolean {
        return userMaster.changePassword(mobileNumber, password, newPassword)
    }

    fun isAnExistingUser(mobileNumber: String): Boolean {
        return userMaster.isAnExistingUser(mobileNumber)
    }

    fun logoutUser(userId: Int) {
        this._loggedInUser = null
    }
}