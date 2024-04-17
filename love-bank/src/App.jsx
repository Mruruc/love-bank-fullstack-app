import { RouterProvider, createBrowserRouter } from 'react-router-dom';
import './App.css'
import {HomePageLayout,About,Help,Pricing, Home} from './home/index';
import {LoginLayout,Login} from './login/index';
import {RegisterLayout,Register,RegisterToApp} from './register/index';
import ErrorPage from './pages/ErrorPage';

const route=createBrowserRouter([
  {
    path:'/',
    element: <HomePageLayout/>,
    errorElement:<ErrorPage/>,
    children:[
      {
        index:true,
        element: <Home/>
      },
      {
        path:'about',
        element: <About/>
      },
      {
        path:'help',
        element:<Help/>
      },
      {
        path:'pricing',
        element:<Pricing/>
      }
    ]
  },
  {
    path:'/login',
    element:<LoginLayout/>,
    children:[
      {
        index: true,
        element:<Login/>
      }
    ]
  },
  {
    path:'/register',
    element:<RegisterLayout/>,
    children:[
      {
        index: true,
        element:<Register/>
      },
      {
        path:'app',
        element:<RegisterToApp/>
      }
    ]
  }
]);

function App() {


  return (
   <>
   <RouterProvider router={route}/>
   </>
  );
}

export default App;
