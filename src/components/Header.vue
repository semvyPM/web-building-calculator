<script setup>

import LogoTest from "@/components/icons/Logo.vue";
import ClientInfoPopup from "@/components/ClientInfoPopup.vue";
</script>

<template>
  <div class="header">
    <div class="logo">
      <LogoTest @click="signOut"/>
    </div>
    <div class="client_data">
      <div v-if="clientData" @click="openClientInfoPopup">
        <ClientInfoPopup v-if="showPopup" @close="showPopup = false" :clientObject="clientObject"/>
        <p  style="font-family: Roboto-Medium">Клиент<br></p>
        <p>
          <span style="font-family: Roboto-Bold">{{ clientObject.lastName }} {{ clientObject.firstName }} {{ clientObject.secondName }}</span> <br>
          <span>{{ clientObject.adress }}</span> <br>
          <span>тел. {{ clientObject.phone }}, {{ clientObject.eMail }}</span>
        </p>
      </div>
    </div>
    <div class="employee">
      <p  style="font-family: Roboto-Medium">
        Сотрудник<br>
      </p>
      <p>
        <span  style="font-family: Roboto-Bold">{{ user[0].usersId.lastName }} {{ user[0].usersId.firstName }} {{ user[0].usersId.secondName }} </span><br>
        <span> {{ groups }} </span>
      </p>
    </div>
    <div class="exit"></div>
  </div>
</template>
<script>
import axios from "axios";

export default {
  props: {
    client: String,
    clientData: Boolean
  },
  data() {
    return {
      showPopup: false,
      clientObject: Object
    }
  },
  computed: {
    user() {
      console.log("user:");
      this.$store.dispatch('loadUser');
      console.log(this.$store.state.user);
      if (this.$store.state.user != null) {
        return this.$store.state.user;
      } else {
        alert("Ошибка авторизации!");
        window.location.href = "/";
      }
    },
    groups() {
      return this.user.map(item => item.usersgroupId.title).join(', ');
    }
  },
  async mounted() {
    this.$store.dispatch('loadUser');
    if (this.clientData === true) {
      await axios.get('http://localhost:8080/api/clients/' + this.client).then(response => {
        this.clientObject = response.data;
      }).catch(error => {
        alert('Ошибка при получении данных клиента', error);
      });
    }
  },
  methods: {
    signOut() {
      this.$router.push({name: "signIn"});
    },
    openClientInfoPopup() {
      this.showPopup = !this.showPopup
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