import LoginHeader from "../login/LoginHeader";
import Footer from "../home/footer/Footer";
import { Outlet } from "react-router-dom";

const RegisterLayout=()=>{
    return(
        <div>
             <LoginHeader/>
             <Outlet/>
             <Footer/>
        </div>
    );
}

export default RegisterLayout;