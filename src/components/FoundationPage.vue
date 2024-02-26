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
      Фундамент
    </p>
  </div>
</div>
<main>
  <form action="">
    <div class="adress">
                <input type="text" placeholder="Добавить адрес объекта строительства">
                <input type="button" value="Сохранить">
                
                <input type="reset" value="Очистить расчет">
            </div>
                <h3>Исходные данные</h3>
                <div class="table floorsInput">Периметр внешних стен <input type="number" placeholder=""> </div>
                <div class="table floorsInput">Длина внутренних стен <input type="number" placeholder=""> </div>
                <div class="submit">
                    <input type="submit" value="Рассчитать">
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
