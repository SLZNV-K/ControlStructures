package ru.netology

import org.junit.Test
import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calculateCommissionForVK() {
        val cardType = "VK Pay"
        val amount = 0
        val transfer = 10_000

        val result = calculateCommission(cardType = cardType, transferAmount = amount, currentTransfer = transfer)

        assertEquals(0.0, result)
    }

    @Test
    fun calculateCommissionForMasterCard() {
        val cardType = "MasterCard"
        val amount = 100
        val transfer = 10_000

        val result = calculateCommission(cardType = cardType, transferAmount = amount, currentTransfer = transfer)

        assertEquals(0.0, result)
    }

    @Test
    fun calculateCommissionForMaestro() {
        val cardType = "Maestro"
        val amount = 100
        val transfer = 10_000

        val result = calculateCommission(cardType = cardType, transferAmount = amount, currentTransfer = transfer)

        assertEquals(0.0, result)
    }

    @Test
    fun calculateCommissionForMasterCardZeroCommission() {
        val cardType = "MasterCard"
        val amount = 10_000
        val transfer = 10_000

        val result = calculateCommission(cardType = cardType, transferAmount = amount, currentTransfer = transfer)

        assertEquals(0.0, result)
    }

    @Test
    fun calculateCommissionForMaestroZeroCommission() {
        val cardType = "Maestro"
        val amount = 10_000
        val transfer = 10_000

        val result = calculateCommission(cardType = cardType, transferAmount = amount, currentTransfer = transfer)

        assertEquals(0.0, result)
    }

    @Test
    fun calculateCommissionForVisa() {
        val cardType = "Visa"
        val amount = 0
        val transfer = 10_000
        val result = calculateCommission(cardType = cardType, transferAmount = amount, currentTransfer = transfer)

        assertEquals(75.0, result)
    }

    @Test
    fun calculateCommissionForMir() {
        val cardType = "Мир"
        val amount = 0
        val transfer = 10_000

        val result = calculateCommission(cardType = cardType, transferAmount = amount, currentTransfer = transfer)

        assertEquals(75.0, result)
    }

    @Test
    fun calculateCommissionForVisaMinCommission() {
        val cardType = "Visa"
        val amount = 0
        val transfer = 4000
        val result = calculateCommission(cardType = cardType, transferAmount = amount, currentTransfer = transfer)

        assertEquals(35.0, result)
    }

    @Test
    fun calculateCommissionForMirMinCommission() {
        val cardType = "Мир"
        val amount = 0
        val transfer = 4000

        val result = calculateCommission(cardType = cardType, transferAmount = amount, currentTransfer = transfer)

        assertEquals(35.0, result)
    }

    @Test
    fun calculateCommissionForVKExceedingTheLimit() {
        val cardType = "VK Pay"
        val amount = 100_000
        val transfer = 10_000


        val result = calculateCommission(cardType = cardType, transferAmount = amount, currentTransfer = transfer)

        assertEquals(0.0, result)
    }

    @Test
    fun calculateCommissionForMasterCardExceedingTheLimit() {
        val cardType = "MasterCard"
        val amount = 1_000_000
        val transfer = 10_000

        val result = calculateCommission(cardType = cardType, transferAmount = amount, currentTransfer = transfer)

        assertEquals(80.0, result)
    }

    @Test
    fun calculateCommissionForMaestroExceedingTheLimit() {
        val cardType = "Maestro"
        val amount = 1_000_000
        val transfer = 10_000


        val result = calculateCommission(cardType = cardType, transferAmount = amount, currentTransfer = transfer)

        assertEquals(80.0, result)
    }

    @Test
    fun calculateCommissionForVisaExceedingTheLimit() {
        val cardType = "Visa"
        val amount = 1_000_000
        val transfer = 10_000


        val result = calculateCommission(cardType = cardType, transferAmount = amount, currentTransfer = transfer)

        assertEquals(75.0, result)
    }

    @Test
    fun calculateCommissionForVKOverTransfer() {
        val cardType = "VK Pay"
        val amount = 100_000
        val transfer = 40_000

        val result = calculateCommission(cardType = cardType, transferAmount = amount, currentTransfer = transfer)

        assertEquals(0.0, result)
    }

    @Test
    fun calculateCommissionForMasterCardOverTransfer() {
        val cardType = "MasterCard"
        val amount = 1_000_000
        val transfer = 200_000


        val result = calculateCommission(cardType = cardType, transferAmount = amount, currentTransfer = transfer)

        assertEquals(1220.0, result)
    }

    @Test
    fun calculateCommissionForMaestroOverTransfer() {
        val cardType = "Maestro"
        val amount = 1_000_000
        val transfer = 200_000

        val result = calculateCommission(cardType = cardType, transferAmount = amount, currentTransfer = transfer)

        assertEquals(1220.0, result)
    }

    @Test
    fun calculateCommissionForVisaOverTransfer() {
        val cardType = "Visa"
        val amount = 1_000_000
        val transfer = 200_000


        val result = calculateCommission(cardType = cardType, transferAmount = amount, currentTransfer = transfer)

        assertEquals(1500.0, result)
    }

    @Test
    fun calculateCommissionForMirOverTransfer() {
        val cardType = "Мир"
        val amount = 1_000_000
        val transfer = 200_000
        val result = calculateCommission(cardType = cardType, transferAmount = amount, currentTransfer = transfer)

        assertEquals(1500.0, result)
    }

    @Test
    fun calculateCommissionForVKSumOver() {
        val cardType = "VK Pay"
        val amount = 35_000
        val transfer = 10_000

        val result = calculateCommission(cardType = cardType, transferAmount = amount, currentTransfer = transfer)

        assertEquals(0.0, result)
    }

    @Test
    fun calculateCommissionForMasterCardSumOver() {
        val cardType = "MasterCard"
        val amount = 500_000
        val transfer = 110_000

        val result = calculateCommission(cardType = cardType, transferAmount = amount, currentTransfer = transfer)

        assertEquals(680.0, result)
    }

    @Test
    fun calculateCommissionForMirExceedingTheLimit() {
        val cardType = "Мир"
        val amount = 1_000_000
        val transfer = 10_000

        val result = calculateCommission(cardType = cardType, transferAmount = amount, currentTransfer = transfer)

        assertEquals(75.0, result)
    }

    @Test
    fun calculateCommissionForMirSumOver() {
        val cardType = "Мир"
        val amount = 500_000
        val transfer = 110_000
        val result = calculateCommission(cardType = cardType, transferAmount = amount, currentTransfer = transfer)

        assertEquals(825.0, result)
    }

    @Test
    fun calculateCommissionForVisaSumOver() {
        val cardType = "Visa"
        val amount = 500_000
        val transfer = 110_000
        val result = calculateCommission(cardType = cardType, transferAmount = amount, currentTransfer = transfer)

        assertEquals(85.0, result)
    }

    @Test
    fun calculateCommissionForMaestroSumOver() {
        val cardType = "Maestro"
        val amount = 500_000
        val transfer = 110_000

        val result = calculateCommission(cardType = cardType, transferAmount = amount, currentTransfer = transfer)

        assertEquals(680.0, result)
    }

}