import './login.css';
import { NavLink } from 'react-router-dom';
import { useEffect, useState } from "react";
import Footer from "../home/footer/Footer";
import LoginHeader from "./LoginHeader";
import sendToApi from '../requests-method/postRequest';

const url='';

const Login=()=>{
   const[getUser,setUser]= useState({email:'',password:'' });

   function handleInputs(event){
       const {name,value} =event.target;
       setUser({...getUser,[name]:value});
   }

   function handleForm(event){
        event.preventDefault();
        const jsonUser=JSON.stringify(getUser);
        useEffect(
            ()=>{
                try{
                    const data=sendToApi(url,jsonUser);
                    console.log(data);
                }catch(error){
                    console.log(error.message);
                }
            },[]
        );
        setUser({email:'',password:''});
        console.log(jsonUser);
   }

    return(
        <div>

            <div className="login-main">
                <h3>
                    <NavLink to='/register'>New to LoveBank Register ?</NavLink>
                </h3>
                  
                <form onSubmit={handleForm} className="form" autoComplete="on">

                    <label htmlFor="email" className="form-label">Email Address</label><br />
                    <input type="email"  className="form-input"
                           name="email" value={getUser.email} id="email"
                           onChange={handleInputs}
                    /> 
                    <br/>
                    
                    <label htmlFor="password" className="form-label"> Password</label><br />
                    <input type="password" className="form-input" 
                           name="password" value={getUser.password} id="password"
                           onChange={handleInputs}
                    />
                    <br/>
                    <button className="login-btn" >Login</button>
                    
                </form>

                <p>
                    Forget Password
                </p>
            </div>

            
        </div>
    );
}

export default Login;