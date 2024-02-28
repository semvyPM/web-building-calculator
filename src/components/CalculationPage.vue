<script setup>
import Logo from './icons/Logo.vue';
import Floor from "@/components/Floor.vue";
import LogoTest from "@/components/icons/Logo.vue";
import Header from "@/components/Header.vue";
</script>

<template>
<Header/>
<div class="nav">
  <div class="back"></div>
  <div class="carcass">
    <p>
        Расчет <input type="button" value="Статус">
    </p>
  </div>
</div>
<main>
  <form action="">
    <h3>Дата: 22.02.2023</h3>
                <h3>Адрес объекта: г.Такой, ул.Такая, д.25</h3>
                <div class="result-buttons">
                    <div>
                        <input class="hide" id="hd-3" type="checkbox" >
                        <label for="hd-3">
                            <div class="plus">
                                <div class="circle">+</div>
                                <div class="plus_text">Результат расчета каркаса</div> 
                            </div>
                        </label>
                        <div>
                            
                        </div>
                    </div>
                    <div class="edit">
                        <img src="@/assets/img/edit.png" alt="">
                    </div>
                    <input type="button" value="Добавить конструктивный элемент">                  
                </div>
                <div class="report">

                </div>
  </form>
</main>
</template>

<script>
export default {
  components: {
    Floor
  },
  data() {
    return {
      floorsCount: 1, // Начальное количество этажей
      floors: [{}] // Массив с данными для каждого этажа, начинаем с одного пустого объекта
    };
  },
  methods: {
    duplicateFloors() {
      // Обновляем количество этажей в соответствии с введенным числом
      const newCount = Number(this.floorsCount);
      if (!isNaN(newCount) && newCount >= 0) {
        const currentCount = this.floors.length;

        if (newCount > currentCount) {
          for (let i = currentCount; i < newCount; i++) {
            this.floors.push({}); // Добавляем пустой объект для нового этажа
          }
        } else if (newCount < currentCount) {
          this.floors = this.floors.slice(0, newCount); // Обрезаем массив до нового количества этажей
        }
      }
    }
  }
}
</script>

<style scoped>
@import '@/assets/style/carcas_page_style/style.css';
@import '@/assets/style/carcas_page_style/slide.css';
@import '@/assets/style/carcas_page_style/responsive.css';
@import url(http://fonts.googleapis.com/css?family=Open+Sans:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i);
@import url(http://fonts.googleapis.com/css?family=Open+Sans:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i);
</style>
