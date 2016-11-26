/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    $("button").click(function(){
        $.post("DictioneryController",
        {
          word: document.getElementById("words").value
        })
        .done(myAjaxSuccessFunction)
        .error(ajaxFailure);
        
    });
});

function myAjaxSuccessFunction(data) {
            $("#display").text("");
            $.each(data, function(key,value){
                $("#display").append("<br><br>" +value); 
            });
  
}
function ajaxFailure(xhr, status, exception) { 
  console.log(xhr, status, exception);
}

