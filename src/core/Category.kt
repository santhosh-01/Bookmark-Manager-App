package core

class Category(private var _name: String) {

    private var _id: Int = -1

    private var _description: String? = null

    constructor(_name: String, _description: String) : this(_name) {
        this._description = _description
    }

    var id: Int
        get() = _id
        set(value) {
            if(_id == -1 && value > 1000)
                _id = value
        }

    var name: String
        get() = _name
        set(value) {
            if(value.isNotEmpty())
                _name = value
        }

    var description: String?
        get() = _description
        set(value) {
            if(value != null && value.isNotEmpty())
                _description = value
        }

}