package com.example.dominio.model


class UserDomain(
    val id: Int,
    val name: String,
    val phone: String,
    val mail: String,
    var posts:List<UserPostsDomain>
){

    override fun equals(other: Any?): Boolean {
        other as UserDomain
        return  id == other.id &&
                name == other.name &&
                phone == other.phone &&
                mail == other.mail &&
                posts.size == other.posts.size
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + phone.hashCode()
        result = 31 * result + mail.hashCode()
        result = 31 * result + posts.hashCode()
        return result
    }

}





