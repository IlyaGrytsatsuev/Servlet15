

function Delete(name){
    var xhr = new XMLHttpRequest();
    var account = document.getElementById(name + "Account");
    var data = "name=" + name + "&state=delete";
   

    xhr.onreadystatechange = function(){
        if(this.readyState == 4 && this.status == 200){
            account.remove();
        }
    }

    xhr.open("POST", "/Servlet15/AccountManager", true);

    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xhr.send(data);

        
}



    
