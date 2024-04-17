

async function sendToApi(url,data){
    const urlObj=new URL(url);
    const request = new Request(
        urlObj,
        {
            method:'POST'
        }
    );

    try{
        const response= await fetch(request);
        if(!response.status === 200){
            throw new Error(`HTTP error! status: ${response.statusText}`);
        }
        const user = response.json();
        return user;
    }catch(error){
        throw new Error();
    }
}

export default sendToApi;