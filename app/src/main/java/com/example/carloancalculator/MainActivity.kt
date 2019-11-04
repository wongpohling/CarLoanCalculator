package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            calculateLoan()
        }
    }


    private fun calculateLoan(){
        //TODO: get all inputs from user and perform calculation

        if(editTextCarPrice.text.isEmpty()){
            editTextCarPrice.setError(getString(R.string.error))
            return
        }
        if(editTextDownPayment.text.isEmpty()){
            editTextDownPayment.setError(getString(R.string.error))
            return
        }
        if(editTextLoanPeriod.text.isEmpty()){
            editTextLoanPeriod.setError(getString(R.string.error))
            return
        }
        if(editTextInterestRate.text.isEmpty()){
            editTextInterestRate.setError(getString(R.string.error))
            return
        }

        val carPrice = editTextCarPrice.text.toString().toFloat()
        val downPayment = editTextDownPayment.text.toString().toFloat()
        val loanPeriod = editTextLoanPeriod.text.toString().toInt()
        val interestRate = editTextInterestRate.text.toString().toFloat()

        val loan = carPrice - downPayment
        textViewLoan.setText(getString(R.string.loan) + "${loan}")

        val interest = loan*loanPeriod*interestRate
        textViewInterest.setText(getString(R.string.interest) + "${interest}")

        val repayment = (loan + interest)/loanPeriod/12
        textViewMonthlyRepayment.setText(getString(R.string.monthly_repayment) + "${repayment}")
    }

    fun resetInput(view: View) {
        //TODO: Clear all inputs and outputs
        editTextCarPrice.setText("")
        editTextDownPayment.setText("")
        editTextLoanPeriod.setText("")
        editTextInterestRate.setText("")
        textViewLoan.setText(getString(R.string.loan))
        textViewInterest.setText(getString(R.string.interest))
        textViewMonthlyRepayment.setText(getString(R.string.monthly_repayment))
    }
}
