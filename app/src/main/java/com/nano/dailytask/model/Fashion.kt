import com.nano.dailytask.model.Product

data class Fashion(
    val total:Int,
    val skip:Int,
    val limit:Int,
    val products: List<Product>
)