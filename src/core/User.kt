package core

class User(private var _mobileNumber: String, private var _password: String) {

    private var _id: Int = -1

    private var _name: String? = null

    constructor(_mobileNumber: String, _password: String, _name: String) :
            this(_mobileNumber,_password) {
                this._name = _name
            }

    var id: Int
        get() = _id
        set(value) {
            if(_id == -1 && value > 1000)
                _id = value
        }

    var mobileNumber: String
        get() = _mobileNumber
        set(value) {
            if(value.length == 10 && value.all { it.isDigit() })
                _mobileNumber = value
        }

    var password: String
        get() = _password
        set(value) {
            if(value.isNotEmpty())
                _password = value
        }

    var name: String?
        get() = _name
        set(value) {
            if(value != null && value.isNotEmpty())
                _name = value
        }

}