import './header.css';
import { Link } from 'react-router-dom';
const Header=()=>{
    return(
     <div className='containerNav'>
        <nav className='navBar'>
            <div className='startNav'>
                LoveBank
            </div>
           <div className='middleNav'>
                <ul className='headers'>
                    <li>
                        <Link to='/'>Home</Link>
                    </li>
                    <li>
                        <Link to='/pricing'>Pricing</Link>
                    </li>
                    <li> 
                        <Link to='/help'>Help</Link>
                    </li>
                    <li>
                        <Link to='/about'>About</Link>
                    </li>
                </ul>
           </div>
            <div className='endNav'>
                <button className='registerButton'>
                    <Link to='/register'>Register</Link>
                </button>
                <button className='loginButton'>
                    <Link to='/login'>Log in</Link>
                </button>
            </div>
       </nav>
     </div>
    );
}

export default Header;
