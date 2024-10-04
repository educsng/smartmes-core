"use client";

import { useState } from "react";
import Breadcrumb from "@/components/Breadcrumbs/Breadcrumb";
import DefaultLayout from "@/components/Layouts/DefaultLaout";
import SelectGroupOne from "@/components/SelectGroup/SelectGroupOne";
import { toast } from "react-toastify";
import { authenticatedRequest } from "@/utils/axios-util";

const OrdersPage = () => {
  const [reason, setReason] = useState("");
  const [equipmentId, setEquipmentId] = useState(0);
  const [priority, setPriority] = useState("");
  const [type, setType] = useState("");
  const [technician, setTechnician] = useState("");

  async function handleRequest() {
    const requestData = {
      reason,
      equipmentId,
      priority,
      type,
      technician,
    };

    try {
      await authenticatedRequest.post(`/api/maintenance-orders`, requestData);

      toast.success("Sucesso ao reportar problema");
    } catch {
      toast.error("Erro ao reportar problema");
    }
  }

  return (
    <DefaultLayout>
      <Breadcrumb pageName="Chamados de Manutenção" />

      <div className="grid">
        <div className="flex flex-col gap-9">
          {/* <!-- Contact Form --> */}
          <div className="rounded-[10px] border border-stroke bg-white shadow-1 dark:border-dark-3 dark:bg-gray-dark dark:shadow-card">
            <div className="border-b border-stroke px-6.5 py-4 dark:border-dark-3">
              <h3 className="font-semibold text-dark dark:text-white">
                Criar Chamados de Manutenção
              </h3>
            </div>
            <form action="#">
              <div className="p-6.5">
                <SelectGroupOne
                  label="Atribuir a um Técnico"
                  callBackValue={(e) => setTechnician(e)}
                >
                  <option value="" disabled className="text-dark-6">
                    Escolha um técnico
                  </option>
                  <option value="1" className="text-dark-6">
                    Carlos Mendes
                  </option>
                  <option value="2" className="text-dark-6">
                    João Silva
                  </option>
                  <option value="3" className="text-dark-6">
                    Ana Oliveira
                  </option>
                  <option value="4" className="text-dark-6">
                    Beatriz Souza
                  </option>
                </SelectGroupOne>

                <SelectGroupOne
                  label="Equipamento"
                  callBackValue={(e) => setEquipmentId(Number(e))}
                >
                  <option value="" disabled className="text-dark-6">
                    Escolha o equipamento
                  </option>
                  <option value="101" className="text-dark-6">
                    Máquina de Corte CNC
                  </option>
                  <option value="102" className="text-dark-6">
                    Prensa Hidráulica
                  </option>
                  <option value="103" className="text-dark-6">
                    Esteira Transportadora
                  </option>
                  <option value="104" className="text-dark-6">
                    Robô de Solda
                  </option>
                  <option value="105" className="text-dark-6">
                    Máquina de Embalagem
                  </option>
                </SelectGroupOne>

                <SelectGroupOne
                  label="Tipo de manutenção"
                  callBackValue={(e) => setType(e)}
                >
                  <option value="" disabled className="text-dark-6">
                    Escolha o tipo de manutenção
                  </option>
                  <option value="production" className="text-dark-6">
                    PRODUÇÃO
                  </option>
                  <option value="inspection" className="text-dark-6">
                    INSPEÇÃO
                  </option>
                  <option value="preventive" className="text-dark-6">
                    PREVENTIVO
                  </option>
                  <option value="predictive" className="text-dark-6">
                    PREDITIVO
                  </option>
                  <option value="incident" className="text-dark-6">
                    INCIDENTE
                  </option>
                </SelectGroupOne>

                <SelectGroupOne
                  label="Prioridade"
                  callBackValue={(e) => setPriority(e)}
                >
                  <option value="" disabled className="text-dark-6">
                    Escolha o tipo de Prioridade
                  </option>
                  <option value="low" className="text-dark-6">
                    BAIXA
                  </option>
                  <option value="medium" className="text-dark-6">
                    MEDIA
                  </option>
                  <option value="high" className="text-dark-6">
                    ALTA
                  </option>
                </SelectGroupOne>

                <div className="mb-6">
                  <label className="mb-3 block text-body-sm font-medium text-dark dark:text-white">
                    Descrição
                  </label>
                  <textarea
                    onChange={(e) => setReason(e.target.value)}
                    rows={6}
                    placeholder="Type your message"
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

export default OrdersPage;
