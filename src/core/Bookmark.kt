package core

class Bookmark(private var _title: String, private var _url: String) {

    private var _id: Int = -1

    private var _description: String? = null

    constructor(_title: String, _name: String, _description: String) : this(_title, _name) {
        this._description = _description
    }

    var id: Int
        get() = _id
        set(value) {
            if(_id == -1 && value > 1000)
                _id = value
        }

    var title: String
        get() = _title
        set(value) {
            if(value.isNotEmpty())
                _title = value
        }

    var url: String
        get() = _url
        set(value) {
            if(value.isNotEmpty())
                _url = value
        }

    var description: String?
        get() = _description
        set(value) {
            if(value != null && value.isNotEmpty())
                _description = value
        }

    override fun toString(): String {
        return "URL ID = " + id +
                ", URL = " + url
    }
}