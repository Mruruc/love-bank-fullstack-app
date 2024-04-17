import "./register.css";
import Address from "./Address";
import { useEffect, useState } from "react";
import sendToApi from "../requests-method/postRequest";
import PersonnelInfo from "./PersonnelInfo";

const url='';

const Register=()=>{
   const [visibility,setVisibility]=useState(true);
   const [getClient,setClient]= useState(
                {
                    firstName:'',
                    lastName:'',
                    dob:'',
                    gender:'',
                    phone:'',
                    email:'',
                    address:{
                        country:'',
                        city:'',
                        street:'',
                        zip:'',
                        doorNo:0,
                    }
                });

    function handleClientInfo(event){
        const {name,value}=event.target;
        const addressFields = ['country', 'city', 'street', 'zip', 'doorNo'];

    if (addressFields.includes(name)) {
        setClient(prev => ({
            ...prev,
            address: { ...prev.address, [name]: value }
        }));
    } else {
        // Update root-level properties for other fields
        setClient(prev => ({
            ...prev,
            [name]: value
        }));
    }
    }

    const handleVisibility=()=>setVisibility(false);

    function handleForm(event){
        event.preventDefault();

        const clientJSON=JSON.stringify(getClient);

        console.log(clientJSON);
    }
    return(
        
        <main className="register-main">
            
            <form onSubmit={handleForm}>

                <PersonnelInfo visibility={visibility} getClient={getClient} 
                               handleClientInfo={handleClientInfo} handleVisibility={handleVisibility}/>

                <Address visibility={visibility} getAddress={getClient.address} handleAddressInfo={handleClientInfo}/>

            </form>
        </main>
        
    );
}

export default Register;

