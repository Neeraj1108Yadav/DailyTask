import com.nano.dailytask.model.CosmeticModel

data class Fashion(
    val total:Int,
    val skip:Int,
    val limit:Int,
    val products: List<CosmeticModel>
)