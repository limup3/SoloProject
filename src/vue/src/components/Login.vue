<template>
    <v-container>
        <v-card v-if="checktwo">
            <v-card-title primary-title class="justify-center">
                <span class="headline">로그인</span>
            </v-card-title>
            <v-card-text>
                <v-container>
                    <v-row>
                        <v-col cols="12">
                            <v-text-field label="ID" v-model="id" required ></v-text-field>
                        </v-col>
                        <!--                                    <v-col cols="12" >-->
                        <!--                                        <v-text-field label="Name" required></v-text-field>-->
                        <!--                                    </v-col>-->
                        <v-col cols="12">
                            <v-text-field label="Password" v-model="password" type="password" required></v-text-field>
                        </v-col>

                    </v-row>
                </v-container>

            </v-card-text>
            <v-card-actions>
                <v-btn left color="blue darken-1" text @click="signup">Signup</v-btn>
                <v-spacer></v-spacer>
                <v-btn color="blue darken-1" text @click="login">Login</v-btn>
                <v-btn right color="blue darken-1" text @click="dialog_login = false">Close</v-btn>

            </v-card-actions>
        </v-card>
    </v-container>
</template>

<script>
    export default {
        data() {
            return {
                dialog_login: false,
                checktwo: true,
                searchWord : "",
                name : '',
                id : '',
                password : '',
                idRules : [
                    v => !!v || 'id is required',
                    v => /^[a-zA-Z0-9]{2,24}$/.test(v) || 'id is invalid'
                ],
                nameRules : [
                    v => !!v || 'name is required',
                    v => /^[a-zA-Z0-9]{2,24}$/.test(v) || 'name is invalid'
                ],
                passwordRules: [
                    v => !!v || 'password is required',
                    v => /^[a-zA-Z0-9]{2,24}$/.test(v) ||
                        'password is invalid'
                ],
                count : 0
            }
        },
        methods: {
            login() {
                let user = new URLSearchParams()
                user.append('total', 'total')
                user.append('id', this.id)
                user.append('password', this.password)
                // alert(Boolean(this.result))
                this.$store.dispatch('member/login', user)
                this.login_reset();
            },
            submit() {
                if (!this.$refs.form.validate()) return;
                let params = new URLSearchParams()
                params.append('total', 'total')
                params.append('id', this.id)
                params.append('name', this.name)
                params.append('password', this.password)
                this.$store.dispatch('member/signup',params)
                this.signup_reset();

            },
            signup_reset() {
                // form 리셋
                this.$refs.form.reset();
                // dialog 비활성화
                this.dialog_signup = false;
            },
            signup(){

                (this.checktwo != false)? this.checktwo = false:this.checktwo = true
            }
        }
    }

</script>

<style scoped>

</style>