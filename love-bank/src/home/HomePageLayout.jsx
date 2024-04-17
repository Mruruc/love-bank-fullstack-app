import { Outlet } from "react-router-dom";
import Footer from "./footer/Footer";
import Header from "./header/Header";

const HomePageLayout=()=>{
    return(
    <>
        <Header/>
        <Outlet/>
        <Footer/>
    </>
    );
}
export default HomePageLayout;