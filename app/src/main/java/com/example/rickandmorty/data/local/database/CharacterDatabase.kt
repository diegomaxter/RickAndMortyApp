package com.example.rickandmorty.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rickandmorty.data.local.CharacterDao
import com.example.rickandmorty.data.local.CharacterEntity

@Database(
    entities = [
        CharacterEntity::class
    ],
    version = 1
)
abstract class CharacterDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao

    companion object {
        private lateinit var database: CharacterDatabase

        fun buildDatabase(context: Context): CharacterDatabase {
            if (!this::database.isInitialized) {
                synchronized(this) {
                    database = Room.databaseBuilder(
                        context,
                        CharacterDatabase::class.java, context.packageName.toString()
                    ).build()
                }
            }
            return database
        }
    }
}
