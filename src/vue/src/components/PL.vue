<!--<template>-->
<!--    <div>-->
<!--        <h3 id="center">사랑받는 프로그래밍 언어 순위 TOP 20</h3>-->
<!--        <div id="size"></div>-->
<!--        <v-simple-table>-->
<!--            <template v-slot:default>-->
<!--                <thead>-->
<!--                <tr>-->
<!--                    <th class="text-left">Jun 2020</th>-->
<!--                    <th class="text-left">Jun 2019</th>-->
<!--                    <th class="text-left">Change</th>-->
<!--                    <th class="text-left">Programming Language</th>-->
<!--                    <th class="text-left">Ratings</th>-->
<!--                    <th class="text-left">Change</th>-->
<!--                </tr>-->
<!--                </thead>-->
<!--                <tbody>-->
<!--                <tr v-for="item of pl" :key="item.thisyear">-->
<!--                    <td>{{ item.thisyear }}</td>-->
<!--                    <td>{{ item.lastyear }}</td>-->
<!--                    <td><img :src="item.changess"></td>-->
<!--                    <td>{{ item.pl }}</td>-->
<!--                    <td>{{ item.rating }}</td>-->
<!--                    <td>{{ item.changerating }}</td>-->
<!--                </tr>-->
<!--                </tbody>-->
<!--            </template>-->
<!--        </v-simple-table>-->
<!--        <div class="text-center">-->
<!--            &lt;!&ndash;            <div style="margin: 0 auto; width: 500px; height: 100px">&ndash;&gt;-->
<!--            &lt;!&ndash;                <span v-if ='pager.existPrev' style="width: 50px; height: 50px; border: 1px solid black;margin-right: 5px">이전</span>&ndash;&gt;-->
<!--            &lt;!&ndash;                <span v-for='i of pages' :key="i" style="width: 50px; height: 50px; border: 1px solid black;margin-right: 5px">{{i}}</span>&ndash;&gt;-->
<!--            &lt;!&ndash;                <span v-if ='pager.existNext' style="width: 50px; height: 50px; border: 1px solid black;margin-right: 5px">다음</span>&ndash;&gt;-->
<!--            &lt;!&ndash;            </div>&ndash;&gt;-->
<!--            &lt;!&ndash;            <v-pagination v-model="page" :length="5" :total-visible="5"></v-pagination>&ndash;&gt;-->
<!--        </div>-->
<!--    </div>-->
<!--</template>-->

<template>
    <v-container>
<!--        <a>DB에 있는 정보수 : {{ count }}</a>-->
        <v-card>
            <v-card-title>
                사랑받는 프로그래밍 언어 순위 TOP 20
                <v-spacer/>
                <v-text-field
                        v-model="search"
                        append-icon="mdi-magnify"
                        label="Search"
                        single-line
                        hide-details
                ></v-text-field>
            </v-card-title>

            <v-data-table
                    :headers="headers"
                    :items="pl"
                    :search="search">
                <template v-slot:item.changess="{item}">
                    <img :src=item.changess />
                </template>

            </v-data-table>
        </v-card>
    </v-container>
</template>

<script>
    import { mapState } from "vuex";
    export default {
        data () {
            return {
                pageNumber: 0,
                search:'',
                existPrev : true,
                existNext : true,
                pages: [1,2,3,4,5],
                list: [],
                pager: {},
                totalCount: '',
                headers: [
                    {
                        text: 'thisyear',
                        value: 'thisyear'
                    },
                    {
                        text: 'lastyear',
                        value: 'lastyear'
                    },
                    {
                        text: 'changess',
                        value: 'changess'
                    },
                    {
                        text: 'pl',
                        value: 'pl'
                    },
                    {
                        text: 'rating',
                        value: 'rating'
                    },
                    {
                        text: 'changerating',
                        value: 'changerating'
                    },
                ]
            }
        },

        computed: {
            ...mapState({

                count: state => state.crawling.count,
                pl: state => state.crawling.pl

            })
        }

    }
</script>

<style scoped>
    #size {
        width: 150px;
        height: 40px;
    }
    #center {
        text-align: center;
    }
</style>