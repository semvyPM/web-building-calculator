/*var x = 0;

function addInput() {
	//if (x < 10) {
    var str = '<br> <div class="table2"> <div>Высота</div> <div>Ширина</div> <div>Количество</div><input type="text" placeholder=""><input type="text" placeholder=""><input type="text" placeholder=""></div><br>';
    document.getElementById('input' + x).innerHTML = str;
    //x++;
  //} else
  //{
  //	alert('STOP it!');
  //}
} */
var $plus11 = document.getElementsByClassName('plus11')[0];
var $plus12 = document.getElementsByClassName('plus12')[0];
var $plus13 = document.getElementsByClassName('plus13')[0];
var $table2 = document.getElementsByClassName('proemi')[0];
$plus11.addEventListener('click', function(event) {
    var $input = document.createElement('div');
    $input.innerHTML = '<div class="table2"><div>Высота</div> <div>Ширина</div> <div>Количество</div><input type="text" placeholder=""><input type="text" placeholder=""><input type="text" placeholder=""></div><br>';
    $table2.insertBefore($input, $plus11);
  });

$plus12.addEventListener('click', function(event) {
    var $input = document.createElement('div');
    $input.innerHTML = '<div class="table2"><div>Высота</div> <div>Ширина</div> <div>Количество</div><input type="text" placeholder=""><input type="text" placeholder=""><input type="text" placeholder=""></div><br>';
    $table2.insertBefore($input, $plus12);
  });

$plus13.addEventListener('click', function(event) {
    var $input = document.createElement('div');
    $input.innerHTML = '<div class="table2"><div>Высота</div> <div>Ширина</div> <div>Количество</div><input type="text" placeholder=""><input type="text" placeholder=""><input type="text" placeholder=""></div><br>';
    $table2.insertBefore($input, $plus13);
  });