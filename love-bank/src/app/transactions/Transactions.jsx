import { useState } from "react";
import Transaction from "./Transaction";
import transactions from "./data.js";
const Transactions=()=>{

    const [getTransactions,setTransactions]=useState(transactions);

    return(
        <div>
            <table>
                <thead>
                    <tr>
                        <th>Transaction Type</th>
                        <th>Amount</th>
                        <th>Date</th>
                    </tr>
                </thead>
                <tbody>

                   {
                    getTransactions.map(transaction=>{
                        return(
                            <Transaction 
                                type={transaction.type}
                                amount={transaction.amount}
                                date={transaction.date}
                            />
                        );
                    })
                   }

                </tbody>
            </table>
        </div>
    );
}

export default Transactions;