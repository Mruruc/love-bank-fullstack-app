

const requestToApi=async()=>{
    const url=new URL('https://api.github.com/users/Mruruc');
    const request=new Request(url);

    try{
        const response=await fetch(request);
        if(!response.status === 200){
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data=await response.json(); 
        return data;
    }catch(error){
        throw new Error('Could Not Reach End Point');
    }
}

export default requestToApi;