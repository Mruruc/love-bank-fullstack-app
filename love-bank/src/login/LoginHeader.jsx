import './login.css';
import { NavLink } from 'react-router-dom';
const LoginHeader=()=>{
    return(
        <header className="login-header">
         <nav className='login-nav'>
            <h1>
               <NavLink to='/'>LoveBank</NavLink>
            </h1>
            <div className='login-home'>
                <NavLink to='/'>Home</NavLink>
            </div>
         </nav>
        </header>
    );
}

export default LoginHeader;