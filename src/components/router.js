import { createRouter, createWebHashHistory } from 'vue-router';
import CarcasPage from '../components/CarcasPage.vue';
import SignInPage from "@/components/SignInPage.vue";
import ClientPage from "@/components/ClientPage.vue";
import ClientsPage from "@/components/ClientsPage.vue";
import CalculationPage from "@/components/CalculationPage.vue";
import FoundationPage from "@/components/FoundationPage.vue";
import RoofPage from "@/components/RoofPage.vue";
const routes = [
    { path: '/', name: 'signIn', component: SignInPage },
    { path: '/carcasPage/:id',  name: 'carcasPage', component: CarcasPage, props: true  },
    { path: '/client/:id',  name: 'clientPage', component: ClientPage, props: true },
    { path: '/clients',  name: 'clientsPage', component: ClientsPage },
    { path: '/calculation/:idcalculation/:idclient',  name: 'calculationPage', component: CalculationPage, props: true },
    { path: '/foundation/:id',  name: 'foundationPage', component: FoundationPage, props: true },
    { path: '/roof/:id',  name: 'roofPage', component: RoofPage, props: true },
];
const router = new createRouter({
    history: createWebHashHistory(),
    routes
});

export default router;