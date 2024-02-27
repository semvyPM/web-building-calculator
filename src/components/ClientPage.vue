<script setup>
import Header from "@/components/Header.vue";
</script>

<template>
<Header/>
  <div class="nav">
    <div class="back"></div>
    
      <p>
        Карточка клиента
      </p>
    </div>
  
  <main>
    <form action="">
      <div class="create-calculation-button">
        <input type="button" style="cursor: pointer;" value="Создать расчет" @click="togglePopup">
        <ConstructionElementPopup v-if="showPopup" @close="showPopup = false"/>
      </div>
    </form>
    <div class="client-bg">
    <hr>
    

    <div class="client">
      <div class="calculation">
        <div class="container"> <div> Расчет №2 </div> </div>
        <div class="container"> <div> 02.02.2021 </div> </div>
        <div class="container"> <div> Актуален </div> </div>
        <div class="container"> <div> Адрес <br> строительства </div> </div>
      </div>
      <div class="buttons">
        <div class="copy">
          <img src="@/assets/img/copy.png" alt="">
        </div>
        <div class="delete">
          <img src="@/assets/img/delete.png" alt="">
        </div>
      </div>

    </div>
    <hr>
    </div>
  </main>
</template>

<script>
import ConstructionElementPopup from "@/components/ConstructionElementPopup.vue";

export default {
  components: {
    ConstructionElementPopup
  },
  data() {
    return {
      showPopup: false
    };
  },
  methods: {
    togglePopup() {
      this.showPopup = !this.showPopup
    },
    saveAndRedirect() {
      alert("saveAndRedirect");
    },
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
