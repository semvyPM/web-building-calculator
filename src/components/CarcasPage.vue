<script setup>
import Floor from "@/components/Floor.vue";
import Logo from "@/components/icons/Logo.vue";
</script>

<template>
<div class="header">
  <div class="logo">
  <Logo/>
  </div>
  <div class="client_data">
    <p>Клиент<br></p>
    <p>
      <b>Тестовый Тест Тестович</b> <br>
      г.Ульяновск, ул. Тестовая, д.35-45 <br>
      тел. 8-900-000-00-00
    </p>
  </div>
  <div class="employee">
    <p>
      Сотрудник<br>
    </p>
    <p>
      <b>Имя Фамилия</b><br>
      должность
    </p>
  </div>
  <div class="exit"></div>
</div>
<div class="nav">
  <div class="back"></div>
  <div class="carcass">
    <p>
      Каркас
    </p>
  </div>
</div>
<main>
  <form action="">
    <div class="adress">
      <input type="text" placeholder="Введите адрес объекта строительства">
      <input type="button" value="Сохранить">

      <input type="reset" value="Очистить расчет">
    </div>
    <h3>Исходные данные</h3>
    <div class="table floorsInput">Количество этажей <input type="number" placeholder="Введите число этажей" v-model="floorsCount" @change="duplicateFloors"> </div>
    <div v-for="(floor, index) in floors" :key="index">
      <h3>Этаж: {{ index + 1 }}</h3>
      <Floor :floor="index" @duplicateInputs="duplicateInputs"></Floor>
    </div>



    <input type="submit" value="Рассчитать">
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
    },
    duplicateInputs(floorIndex) {
      // Дублирование блока инпутов для конкретного этажа
      this.floors.splice(floorIndex + 1, 0, {});
    }

  }
}
</script>

<style scoped>
@import '../assets/style/carcas_page_style/style.css';
@import '../assets/style/carcas_page_style/slide.css';
@import '../assets/style/carcas_page_style/responsive.css';
@import url(http://fonts.googleapis.com/css?family=Open+Sans:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i);
@import url(http://fonts.googleapis.com/css?family=Open+Sans:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i);
</style>
