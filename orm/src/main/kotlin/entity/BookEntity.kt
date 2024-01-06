package entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "books")
class BookEntity(
    @Id
    @GeneratedValue
    var id: Long = 0,
    var name: String,
    @Column(name = "is_taken")
    var isTaken: Boolean,
    @ManyToOne(cascade = [CascadeType.ALL])
    var library: LibraryEntity,
    @CreationTimestamp
    @Column(name = "created_time")
    var createdTime: LocalDateTime? = null,
    @UpdateTimestamp
    @Column(name = "updated_time")
    var updatedTime: LocalDateTime? = null
) {
    override fun toString(): String = "BookEntity(id=$id, name=$name, isTaken=$isTaken, library_id=${library.id})"
}