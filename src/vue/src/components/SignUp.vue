<template>
    <v-container>
        <!--                        회원가입 모달창-->
        <v-card v-if="checktwo">
            <v-card-title primary-title class="justify-center">
                <span class="headline">회원가입</span>
            </v-card-title>
            <v-card-text>
                <v-form
                        persistent
                        ref="form"
                >
                    <v-container>
                        <v-row>
                            <v-col cols="12">
                                <v-text-field label="ID" v-model="id" :rules="idRules"
                                              required></v-text-field>
                            </v-col>
                            <v-col cols="12">
                                <v-text-field label="Name" v-model="name" :rules="nameRules"
                                              required></v-text-field>
                            </v-col>
                            <v-col cols="12">
                                <v-text-field label="Password" v-model="password" :rules="passwordRules"
                                              type="password" required></v-text-field>
                            </v-col>

                        </v-row>
                    </v-container>
                </v-form>
            </v-card-text>
            <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="blue darken-1" text @click="submit">Save</v-btn>
                <v-btn right color="blue darken-1" text @click="dialog_signup = false">Close</v-btn>

            </v-card-actions>
        </v-card>
    </v-container>
</template>

<script>
    export default {
        name: "SignUp",
        data() {
            return {
                dialog_login: false,
                dialog_signup : false,
                checktwo: false,
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
            // dialog_login() {
            //
            // },
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
                // (this.checktwo != false)? this.checktwo = true:this.checktwo = false
            }
        }
    }

</script>

<style scoped>

</style>