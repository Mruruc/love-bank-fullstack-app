
function customDate(date){
    return `${date.getFullYear()}-${date.getMonth()+1}-${date.getDate()}  ${date.getHours()}:${date.getMinutes()}`;
}
const Transaction=(props)=>{
    return(
        <tr>
            <td>{props.type}</td>
            <td>{props.amount}</td>
            <td>{customDate(props.date)}</td>
        </tr>
       
    );
}

export default Transaction;