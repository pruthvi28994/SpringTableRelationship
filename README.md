# Spring Table Relations 
## Database relationships are associations between tables that are created using join statements to retrieve data. There 2 Different types of associations that Tables can have.

## Un-Directional Associations : Unidirectional associations are commonly used in object-oriented programming to establish relationships between entities.However, it’s important to note that in a unidirectional association, only one entity holds a reference to the other.To define a unidirectional association in Java, we can use annotations such as @ManyToOne, @OneToMany, @OneToOne, and @ManyToMany. By using these annotations, we can create a clear and well-defined relationship between two entities in our code.

1. One-To-Many : an entity has a reference to one or many instances of another entity.
2. Many-To-One : many instances of an entity are associated with one instance of another entity.
3. One-To-One : an instance of an entity is associated with only one instance of another entity.
4. Many-To-Many : many instances of an entity are associated with many instances of another entity. @JoinTable should be used by giving Join Table Name , Primary Key & Foriegn Key Columns.
     Ex: @JoinTable(name = "course_student",
							joinColumns = @JoinColumn(name = "course_id"),
							inverseJoinColumns = @JoinColumn(name = "student_id"))
							
	NOTE: We cannot create a JPA Repository for Table "course_student" because for JPA Repository we need Entity as course_student is not Entity.

## Bi-Directional : A bidirectional association is a relationship between two entities where each entity has a reference to the other.Navigable in both directions – from either table to the other.More flexible as changes in either table can be made independently without affecting the other.

NOTE: We can also Create a custum JPA queries apart from Inbuilt ones , have added in respective Entity Repository file kindly go through that