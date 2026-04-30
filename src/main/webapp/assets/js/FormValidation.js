
let mobile=document.querySelector("#mobileNo");
let mail=document.querySelector("#mail");
let password=document.querySelector("#password");
let confirmpassword=document.querySelector("#confirm-password");
let ismobilevalid=true;
let ismailvalid=true;
let ispasswordvalid=true;
let isconfirmpasswordvalid=true;

mobile.addEventListener('blur',() => {
    let mobilespan=document.querySelector("#mobile-span");
    let mobileno=mobile.value.length;
    console.log(mobileno);
    
    if(mobileno !== 10)
    {
        ismobilevalid=false;
        mobilespan.style.color="red";
        mobilespan.textContent="* mobile Number must contain Exactly 10 digits";
    }else {
        ismobilevalid=true;
        // This is the "Clear" logic essential for good UX
        mobilespan.textContent = ""; 
    }
});

mail.addEventListener('blur',() => {
    const emailPattern=/^[a-zA-Z0-8._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    let mailContent=mail.value;
    let emailspan=document.querySelector("#email-span");
    if(!emailPattern.test(mailContent))
    {
        ismailvalid=false;
        emailspan.style.color="red";
        emailspan.textContent="* email must be this format ramu65@gmail.com";
    }
    else
    {
        ismailvalid=true;
        emailspan.textContent="";
    }
});

password.addEventListener('blur',()=>{
    const pattern1=/^(?=.*[A-Z]).+$/;
    const pattern2=/^(?=.*[\W_]).+$/;
    const pattern3=/^(?=(.*\d){2,}).+$/;
    let pwdvalue=password.value;

    if(!pattern1.test(pwdvalue))
    {
        ispasswordvalid=false;
         let pwdspan=document.querySelector("#pwd1-span");
         pwdspan.style.color="red";
         pwdspan.textContent="* Must have: 1 Capital";
    }
    else if(!pattern2.test(pwdvalue))
    {
        ispasswordvalid=false;
        let pwdspan=document.querySelector("#pwd1-span");
        pwdspan.style.color="red";
        pwdspan.textContent="* Must have: 1 Special Char";
    }
    else if(!pattern3.test(pwdvalue))
    {
        ispasswordvalid=false;
        let pwdspan=document.querySelector("#pwd1-span");
        pwdspan.style.color="red";
        pwdspan.textContent="* Must have: 2 Digits";
    }
    else if(pwdvalue.length<8)
    {
        ispasswordvalid=false;
        let pwdspan=document.querySelector("#pwd1-span");
        pwdspan.style.color="red";
        pwdspan.textContent="* Password must contain at least 8 characters";
    }
    else
    {
        ispasswordvalid=true;
        let pwdspan=document.querySelector("#pwd1-span");
        pwdspan.textContent="";
    }

});


confirmpassword.addEventListener('blur',()=>{
    let pwdvalue=password.value;
    let confirmpwdvalue=confirmpassword.value;
    console.log(pwdvalue);
    console.log(confirmpwdvalue);
    if(pwdvalue !== confirmpwdvalue)
    {
        isconfirmpasswordvalid=false;
        let pwdspan=document.querySelector("#pwd2-span");

        pwdspan.style.color="red";
        pwdspan.textContent="* confirm-password and password are not same";
    }
    else
    {
        isconfirmpasswordvalid=true;
        let pwdspan=document.querySelector("#pwd2-span");
        pwdspan.textContent="";
    }

});


let form=document.querySelector("#register");
form.addEventListener('submit',(e) => {
    if(!ismobilevalid || !ismailvalid || !ispasswordvalid || !isconfirmpasswordvalid)
    {
        e.preventDefault(); // Stop submission
        alert("Correct the red errors first!");
    }
});