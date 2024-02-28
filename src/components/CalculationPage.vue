<template>
  <Header :client="iduser" :clientData="clientData"/>
  <div class="nav">
    <router-link :to="'/client/' + iduser"><div class="back"></div></router-link>
    <div class="carcass">
      <p>
        Расчет <input type="button" :value="calculation && calculation.сalculationStateId ? calculation.сalculationStateId.stateName : ''">
      </p>

    </div>
  </div>
  <main>
    <form action="">
      <h3>Дата: {{ calculation.createdDate}}</h3>
      <h3>Адрес объекта: {{ calculation.addressObjectConstractions }}</h3>
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
import Header from "@/components/Header.vue";
import axios from "axios";

export default {
  components: {Header},
  props: {
    iduser: "",
    id: ""
  },
  data() {
    return {
      clientData: true,
      calculation: {}
    }
  },
  async mounted() {
    await axios.get('http://localhost:8080/api/calculations/' + this.id)
        .then(response => { this.calculation = response.data; console.log(this.calculation);})
        .catch(error => { alert('Ошибка при получении данных расчетов', error); });
  },
  methods: {
    backToClient() {
      alert(this.$props.iduser);
      this.$router.push({ name: "clientPage" });
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
<script setup>
import Header from "@/components/Header.vue";
</script>