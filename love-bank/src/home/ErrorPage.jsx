import { Link, useRouteError } from "react-router-dom";

const ErrorPage=()=>{
    const error=useRouteError();
    
    if(error.status){
        return(
            <div className="error-page">
                <h4>404 Not Found!</h4>
                <Link to='/'>back to home...</Link>
            </div>
        );
    }
    return(
        <div>
            Something went wrong....
            <p>
                <Link to='/'>back to home...</Link>
            </p>
        </div>
    );
}

export default ErrorPage;