import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shoppinglist.data.entity.ShoppingItem

@Dao
interface ShoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query(
        "SELECT * " +
                "FROM shopping_item"
    )
    fun getAll(): LiveData<List<ShoppingItem>>
}