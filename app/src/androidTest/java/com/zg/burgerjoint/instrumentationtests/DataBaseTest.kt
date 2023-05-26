package com.zg.burgerjoint.instrumentationtests

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.zg.burgerjoint.data.vos.BurgerVO
import com.zg.burgerjoint.persistence.BurgerJointDatabase
import com.zg.burgerjoint.persistence.daos.BurgerDao
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DataBaseTest {
    //Dao and DataBase
    private lateinit var burgerDao: BurgerDao
    private lateinit var db: BurgerJointDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, BurgerJointDatabase::class.java
        ).build()
        burgerDao = db.getBurgerDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun insertIntoDataBaseTest() {
        val burgerOne = BurgerVO()
        burgerOne.burgerName = "ChickenBurger"
        burgerOne.burgerDescription =
            "A chicken sandwich is a sandwich that typically consists of boneless, skinless chicken breast or thigh served between slices of bread, on a bun, or on a roll. Variations on the \"chicken sandwich\" include the chicken burger, chicken on a bun, chickwich, hot chicken, or chicken salad sandwich."
        burgerOne.burgerImageUrl="https://www.google.com/imgres?imgurl=https%3A%2F%2Fwww.kitchensanctuary.com%2Fwp-content%2Fuploads%2F2019%2F08%2FCrispy-Chicken-Burger-square-FS-4518-500x500.jpg&tbnid=4hgOuiQK-IIxKM&vet=12ahUKEwiKnZzsvJL_AhU3i9gFHeEKBCEQMygBegUIARCOAg..i&imgrefurl=https%3A%2F%2Fwww.kitchensanctuary.com%2Fcrispy-chicken-burger-honey-mustard-coleslaw%2F&docid=V7M6eKEfb2GitM&w=500&h=500&q=chicken%20burger&ved=2ahUKEwiKnZzsvJL_AhU3i9gFHeEKBCEQMygBegUIARCOAg"
        burgerDao.insert(burgerOne)
    }
}