import com.nano.dailytask.model.CosmeticProducts

data class Fashion(
    val total:Int,
    val skip:Int,
    val limit:Int,
    val products: List<CosmeticProducts>
)