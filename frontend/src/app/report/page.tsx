"use client";
import Breadcrumb from "@/components/Breadcrumbs/Breadcrumb";
import DefaultLayout from "@/components/Layouts/DefaultLaout";
import SelectGroupOne from "@/components/SelectGroup/SelectGroupOne";
import { useState } from "react";
import axios from "axios";
import { toast } from "react-toastify";

const ReportPage = () => {
  const [machine, setMachine] = useState("");
  const [resume, setResume] = useState("");

  async function handleRequest() {
    const requestData = {
      reason: resume,
      equipmentId: machine,
    };

    try {
      await axios.post(
        `${process.env.API_URL}/api/maintenance-orders/incident`,
        requestData
      );

      toast.success("Sucesso ao reportar problema");
    } catch {
      toast.error("Erro ao reportar problema");
    }
  }

  return (
    <DefaultLayout>
      <Breadcrumb pageName="Reportar Problema" />

      <div className="grid">
        <div className="flex flex-col gap-9">
          <div className="rounded-[10px] border border-stroke bg-white shadow-1 dark:border-dark-3 dark:bg-gray-dark dark:shadow-card">
            <div className="border-b border-stroke px-6.5 py-4 dark:border-dark-3">
              <h3 className="font-semibold text-dark dark:text-white">
                Reportar Problema
              </h3>
            </div>
            <form action="#">
              <div className="p-6.5">
                <SelectGroupOne
                  label="Maquina"
                  callBackValue={(e) => setMachine(e)}
                >
                  <option value="" disabled className="text-dark-6">
                    Escolha a maquina
                  </option>
                  <option value="production" className="text-dark-6">
                    Maquina 1
                  </option>
                  <option value="inspection" className="text-dark-6">
                    Maquina 2
                  </option>
                  <option value="preventive" className="text-dark-6">
                    Maquina 3
                  </option>
                </SelectGroupOne>

                <div className="mb-6">
                  <label className="mb-3 block text-body-sm font-medium text-dark dark:text-white">
                    O que está acontecendo?
                  </label>
                  <textarea
                    onChange={(e) => setResume(e.target.value)}
                    rows={6}
                    placeholder="Escreva aqui o que está acontecendo"
                    className="w-full rounded-[7px] border-[1.5px] border-stroke bg-transparent px-5 py-3 text-dark outline-none transition placeholder:text-dark-6 focus:border-primary active:border-primary disabled:cursor-default dark:border-dark-3 dark:bg-dark-2 dark:text-white dark:focus:border-primary"
                  ></textarea>
                </div>
                <button
                  onClick={() => handleRequest()}
                  className="flex w-full justify-center rounded-[7px] bg-primary p-[13px] font-medium text-white hover:bg-opacity-90"
                >
                  Enviar
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </DefaultLayout>
  );
};

export default ReportPage;
