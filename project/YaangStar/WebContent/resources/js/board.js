$("#imgFile").on('change',()=>{
      let selectFile = document.querySelector("#imgFile").files[0];

      const file = URL.createObjectURL(selectFile);

      $('#board-img').css('background-image', 'url('+ file +')')
      

})