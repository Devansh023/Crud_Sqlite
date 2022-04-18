package com.example.electronics

data class model(var name: String, var desc: String) {
    var id = 0

    constructor(id: Int, name: String, desc: String) : this(name, desc) {
        this.id = id
    }

    var price: String = ""

    constructor(name: String, desc: String, price: String) : this(name, desc) {
        this.price = price
    }

    constructor(id: Int, name: String, desc: String, price: String) : this(name, desc) {
        this.price = price
        this.id = id
    }

}


//data class Student(val item:String , val desc:String) {
//
//    var id = 0;
//    constructor(id:Int, item: String,desc:String):this(item, desc){
//        this.id = id
//    }
//
//
//    var price:String = ""
//    var quentity:String = ""
//
//    constructor(item: String,desc: String,price:String,quentity:String):this(item, desc){
//        this.price = price
//        this.quentity = quentity
//    }
//
//

//    constructor(item: String,desc: String,price: String):this(item, desc){
//        this.price = price
//    }
//
//    constructor(id: Int,item: String,desc: String,price: String):this(item, desc){
//        this.price = price
//        this.id = id
//    }

//
//    constructor(id: Int,item: String,desc: String,price: String,quentity: String):this(item, desc){
//        this.id = id
//        this.price = price
//        this.quentity = quentity
//    }
//
//
//
//
//
//}