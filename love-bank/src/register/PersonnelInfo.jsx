

const PersonnelInfo=(prop)=>{
    const {visibility,getClient,handleClientInfo,handleVisibility}=prop;
    return(
        <fieldset style={{display:visibility ?'block' : 'none'}}>
                    <legend>Personal Information</legend>

                    <label htmlFor="f_name">First Name</label> <br/>
                    <input type="text" 
                           name="firstName" value={getClient.firstName}
                           id="f_name"
                           onChange={handleClientInfo}
                    /> <br/>

                    <label htmlFor="l_name">Last Name</label> <br/>
                    <input type="text" 
                           name="lastName" value={getClient.lastName}
                           id="l_name" onChange={handleClientInfo}
                    /> <br/>

                    <label htmlFor="dob">Date Of Birth</label> <br/>
                    <input type="date" name="dob" 
                           value={getClient.dob}
                           onChange={handleClientInfo}
                    /> <br/>

                    <label htmlFor="gender">Gender</label> <br/>
                    <select id="gender" value={getClient.gender} name="gender" onChange={handleClientInfo}>
                        <option value=''>--choose--</option>
                        <option value="FEMALE">FEMALE</option>
                        <option value="MALE">MALE</option>
                        <option value="OTHERS">OTHERS</option>
                    </select> <br />

                    <label htmlFor="phone">Phone Number</label> <br/>
                    <input type="text" name="phone"
                           value={getClient.phone} id="phone"
                           onChange={handleClientInfo}
                    /> <br/>

                    <label htmlFor="email">Email</label> <br/>
                    <input type="email" name="email" value={getClient.email} id="email"
                           onChange={handleClientInfo}
                    /> <br/>

                    <button type="button" onClick={handleVisibility}>Next</button>
                </fieldset>
    );
}

export default PersonnelInfo;