import { Outlet } from "react-router-dom";
import Footer from "../home/footer/Footer";
import LoginHeader from "./LoginHeader";

const LoginLayout=()=>{
    return(
        <div>
            <LoginHeader/>
            <Outlet/>
            <Footer/>
        </div>
    );
}

export default LoginLayout;