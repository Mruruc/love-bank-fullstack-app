import "./register.css";
import { useState } from "react";


const RegisterToApp=()=>{
    const [getUser,setUser]=useState({clientId:0,userName:'',password:''});

    const handleInputs=(event)=>{
        setUser((prev)=>{
            return {
                ...prev,
                [event.target.name]:event.target.value
            }
        });
    }

    const handleForm=(event)=>{
        event.preventDefault();

        const newUserJSON=JSON.stringify(getUser);
        // send to db
        console.log(newUserJSON);
    }

    return(
        <main className="register-To-App">
            <div>
                <p>You almost there...</p>
                <p>Last Step Enter Your Password</p>
            </div>
            
            <form onSubmit={handleForm} autoComplete="On">
                <label htmlFor="userName">Email</label> <br />
                <input type="email" name="userName" id="userName" value={getUser.userName} onChange={handleInputs}/> <br />

                <label htmlFor="password">Password</label> <br />
                <input type="password" name="password" id="password" value={getUser.password} onChange={handleInputs}/> <br />

                <button>Login</button>
            </form>
        </main>
    );
}

export default RegisterToApp;