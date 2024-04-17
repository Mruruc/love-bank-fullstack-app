const Address=(prop)=>{
    const {visibility,getAddress,handleAddressInfo}=prop;
    return(
        <fieldset  style={{display: visibility ? 'none': 'block'}}>
            <legend>Address Information</legend>

            <label htmlFor="country">Country</label> <br/>
            <input type="text" name="country" value={getAddress.country} id="country" onChange={handleAddressInfo}/> <br/>
            <label htmlFor="city">City</label> <br />
            <input type="text" name="city" value={getAddress.city} id="city" onChange={handleAddressInfo}/> <br />
            <label htmlFor="street">Street</label> <br />
            <input type="text" name="street" value={getAddress.street} id="street" onChange={handleAddressInfo}/> <br />
            <label htmlFor="zip">Zip-code</label> <br />
            <input type="text" name="zip" value={getAddress.zip} id="zip" onChange={handleAddressInfo}/> <br />
            <label htmlFor="doorNo">Flat or House Number</label> <br />
            <input type="number" min={0} name="doorNo" value={getAddress.doorNo} id="doorNo" onChange={handleAddressInfo}/> <br />

            <button>Register</button>
         </fieldset>
    );
}

export default Address;