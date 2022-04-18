package core

private var _userId: Int = 1001

class UserMaster {

    private var _users: MutableMap<Int, User> = HashMap()

    fun addUser(user: User) {
        user.id = _userId
        _users[_userId] = user
        _userId ++
    }

    fun getUser(mobileNumber: String, password: String): User? {
        for (user in _users.values) {
            if(user.mobileNumber == mobileNumber && user.password == password) {
                return user
            }
        }
        return null
    }

    fun getUser(userId: Int): User? {
        return _users[userId]
    }

    fun removeUser(userId: Int) {
        _users.remove(userId)
    }

    fun isAnExistingUser(mobileNumber: String): Boolean {
        val mobileNumbers: List<String> = _users.map { it.value.mobileNumber }
        return mobileNumber in mobileNumbers
    }

    fun changePassword(mobileNumber: String, password: String, newPassword: String): Boolean {
        val user: User? = getUser(mobileNumber,password)
        if (user != null) {
            user.password = newPassword
            return true
        }
        return false
    }

}